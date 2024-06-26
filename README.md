Esta es una aplicación para la administración de un restaurante (en este caso, el restaurante se llama "El Patio"), programada en Java con el ORM "JPA".
Esta app cuenta con un ABML para las formas de pago, categorías de los productos del menú, productos del menú y mesas.
También tiene una funcionalidad para que el cajero pueda abrir una mesa (indicar que está ocupada) y anotar los productos que esa mesa consume. Cada vez que se abre una mesa, se crea una factura, la cual va a estar asociada a distintos detalles de factura en los cuales
se irán anotando los productos que consume la mesa y su precio. Al cerrar la mesa, el programa pedirá la forma de pago con la que el cliente pagará e indicará el total a pagar (la sumatoria de todos los detalle de factura).
Por último, hay un apartado en el cual el usuario podrá ver todas las facturas y consultar el total facturado. Puede filtrar por fecha si quiere.
Están hechas todas las validaciones correctamente para que el programa no dé fallos.
