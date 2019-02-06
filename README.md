# Almacen
Operaciones habituales sobre un almacén de datos: Poner, Sacar, Buscar, Vaciar, Modificar, Ordenar.

La clase Almacen1 implementa una tabla con huecos, donde existe un valor que indica que la posición está libre. 
Las posiciones se van ocupando y liberando según entrar y salen valores.

La clase Almacen2 implementa una tabla de dos zonas: zona ocupada y zona libre. 
Con un contador que indica cual es la última posición libre, o el número de elementos almacenados. 
Podemos añadir siempre al final de la zona ocupada o insertar en orden para mantener siempre la tabla ordenada.
Cuando eliminamos un elemento desplazamos para que no haya huecos.

He incluido las clases TestAlmacen1 y TestAlmacen2 para probar las clases Almacen1 y Almacen2 respectivamente.
