He deplegado la aplicacion en render, usando un dockerfile, y subiendo un docker con la base de datos postgres.
https://appmoviesv3.onrender.com/

Esta aplicación cuenta con una API REST con varios endpoints que implementan operaciones CRUD, como filtrar películas, añadir nuevas películas y eliminarlas.
He utilizado Spring con Hibernate/JPA y una base de datos postgres desplegada en un contenedor en un servidor local, la app puede tardar en cargar porque se tiene que desplegar desde render, una vez esta activa deberia ir fluida.
