
package elpatio.elpatioapp.logica;

import elpatio.elpatioapp.persistencia.ControladoraPersistencia;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladoraLogica {
    
    //Instanciamos un objeto de la clase ControladoraPersistencia
    ControladoraPersistencia conPer = new ControladoraPersistencia();
    
    
    //// Métodos para DetalleFactura ////
        
        //Trae todos los detalles de factura de una factura específica
        public ArrayList<DetalleFactura> traerDetallesDeFactura(int numeroFactura){
            return conPer.traerDetallesDeFactura(numeroFactura);
        }
    
        //Trae todos los detalle de factura de una mesa que está siendo utilizada
        public ArrayList<DetalleFactura> traerDetalleFacturaMesa(int numeroMesa){
            return conPer.traerDetalleFacturaMesa(numeroMesa);
        }
    
    
        //Trae el próximo detalle de factura de una factura
        public int traerProximoDetalleFactura(int numeroFactura){
            if(conPer.traerUltimoDetalleFactura(numeroFactura) == -1){
                return 1;
            }
            return (conPer.traerUltimoDetalleFactura(numeroFactura) + 1);
            
        }
        
        //Crear DetalleFactura
        public void crearDetalleFactura(DetalleFactura df) throws Exception{
            conPer.crearDetalleFactura(df);
        }
    
    
    //// Métodos para la clase Factura ////

        //Crear Factura
        public void crearFactura(Factura fac){
            conPer.crearFactura(fac);
        }

        //Traer número de factura actual de la mesa ocupada
        public int traerNumeroDeFactura(int numeroMesa){
            if(conPer.traerNumeroDeFactura(numeroMesa) == -1){
                return 1;
            }
            return conPer.traerNumeroDeFactura(numeroMesa);
        }
    
        //Traer una factura por número de factura
        public Factura traerUnaFactura(int numeroFactura){
            return conPer.traerUnaFactura(numeroFactura);
        }
    
        //Editar Factura
        public void editarFactura(Factura fac){
            conPer.editarFactura(fac);
        }
        
        //Traer todas las facturas
        public ArrayList<Factura> traerFacturas(){
            return conPer.traerFacturas();
        }
    
        //Filtro factura por fecha
        public ArrayList<Factura> filtroFechaFacturas(LocalDateTime fechaDesde, LocalDateTime fechaHasta){
            return conPer.filtroFechaFacturas(fechaDesde, fechaHasta);
        }
        
    //// Métodos para la clase Mesa ////

        //Crear una mesa
        public void crearMesa(int numeroMesa, String estado){
            Mesa me = new Mesa();

            me.setEstado_Me(estado);
            me.setNumeroMesa_Me(numeroMesa);

            conPer.crearMesa(me);

        }

        //Buscar si existe la mesa con el número ingresado
        public int existeMesa(int numeroMesa){
            return conPer.existeMesa(numeroMesa);
        }

        //Traer todas las mesas de la base de datos
        public ArrayList<Mesa> traerMesas(){
            return conPer.traerMesas();
        }

        //Traer una sola mesa
        public Mesa traerUnaMesa(int numeroMesa){
            return conPer.traerUnaMesa(numeroMesa);
        }

        //Editar mesa
        public void editarMesa(Mesa me){
            conPer.editarMesa(me);
        }



    //// Métodos para la clase FormaDePago ////
    
        //Agregar forma de pago
        public void crearFormaDePago(String nombre, Boolean estado){
            FormaDePago fdp = new FormaDePago();

            fdp.setFormaDePago_FP(nombre);
            fdp.setEstado_FP(estado);

            conPer.crearFormaDePago(fdp);
        }

        //Traer formas de pago
        public ArrayList<FormaDePago> traerFormasDePago() {
            return conPer.traerFormaDePago();
        }

        //Traer solo una forma de pago
        public FormaDePago traerUnaFormaDePago(int id){
            return conPer.traerUnaFormaDePago(id);
        }


        //Editamos el Fdp
        public void editarFdp(FormaDePago fdp) {
            conPer.editarFdp(fdp);
        }
    
        //Traer forma de pago según un nombre específico
        public FormaDePago traerUnaFormaDePagoPorNombre(String nombre){
            return conPer.traerUnaFormaDePagoPorNombre(nombre);
        }
    
    
    
    //// Métodos para la clase Categoria ////
    
        //Crear categoría
        public void crearCategoria(String nombre, Boolean estado){
            Categoria cat = new Categoria();

            cat.setCategoria_Ca(nombre);
            cat.setEstado_Ca(estado);

            conPer.crearCategoria(cat);
        }

        //Traer ArrayList con todas las categorías
        public ArrayList<Categoria> traerCategorias(){
            return conPer.traerCategorias();
        }

        //Traer una categoría según su id
        public Categoria traerUnaCategoria(int id){
            return conPer.traerUnaCategoria(id);
        }


        //Traer una categoría según su nombre
        public Categoria traerUnaCategoriaSegunNombre(String nombre){
            return conPer.traerCategoriaSegunNombre(nombre);
        }


        //Editar categoría
        public void editarCategoria(Categoria cat){
            conPer.editarCategoria(cat);
        }
    
    
    
    //// Métodos para la clase Menu ////
    
        //Crear producto del menú
        public void crearMenu(String nombre, float precio, Boolean estado, Categoria cat){
            Menu men = new Menu();

            men.setCat_Me(cat);
            men.setEstado_Me(estado);
            men.setNombre_Me(nombre);
            men.setPrecio_Me(precio);

            conPer.crearMenu(men);

        }

        //Traer todos los productos del menú
        public ArrayList<Menu> traerMenu(){
            return conPer.traerMenu();
        }


        //Traer un producto específico del menú
        public Menu traerUnMenu(int id){
            return conPer.traerUnMenu(id);
        }

        //Editar producto específico del menú
        public void editarMenu(Menu men){
            conPer.editarMenu(men);
        }

        //Traer un menú según su nombre
        public Menu traerUnMenuSegunNombre(String nombre){
            return conPer.traerUnMenuSegunNombre(nombre);
        }
    
    
}
