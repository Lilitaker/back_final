let list = document.querySelector(".responsive-table");
let form = document.querySelector("form");
let input_id = document.querySelector(".input_id");
let message= document.querySelector(".mensaje");

window.onload = function () {

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    console.log(input_id.value);
    fetch(`http://localhost:8081/odontologos/${input_id.value}`)
      .then(function (response) {
        return response.json();
      })
      .then(function (odontologo) {
            list.innerHTML = `
                    <li class="table-header">
                        <div class="col col-1">Id</div>
                        <div class="col col-2">Matrícula</div>
                        <div class="col col-3">Nombre</div>
                        <div class="col col-4">Apellido</div>
                        <div class="col col-5">Eliminar</div>
                    </li>
                    <li class="table-row">
                        <div class="col col-1" data-label="Id">${odontologo.id}</div>
                        <div class="col col-2" data-label="Matricula">${odontologo.matricula}</div>
                        <div class="col col-3" data-label="Nombre">${odontologo.nombre}</div>
                        <div class="col col-4" data-label="Apellido">${odontologo.apellido}</div>
                        <div class="col col-5" data-label="Eliminar" value=${odontologo.id}><button class="eliminar">Eliminar</button></div>
                    </li> `;

                    message.style.visibility = "hidden";
                    let botonBorrar = document.querySelector(".eliminar")

                    botonBorrar.addEventListener("click", function(e){

                        e.preventDefault();

                        function eliminarItem() {

                            let confirmacion = confirm(
                              "¿Está seguro de que desea borrar este campo?"
                            );

                            if (confirmacion) {
                              fetch(`http://localhost:8081/odontologos/${input_id.value}`, {
                                method: "DELETE",
                                headers: {
                                  "Content-Type": "application/json",
                                },
                              });

                              location.reload();
                            }
                          }
                          eliminarItem();
                        }

                    )


      })
      .catch(function (error) {
        console.log(error);
        message.style.visibility = "visible";
      });
  });

};
