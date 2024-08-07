
package elpatio.elpatioapp.persistencia;

import elpatio.elpatioapp.logica.Menu;
import elpatio.elpatioapp.logica.Categoria;
import elpatio.elpatioapp.logica.DetalleFactura;
import elpatio.elpatioapp.logica.Factura;
import elpatio.elpatioapp.logica.FormaDePago;
import elpatio.elpatioapp.logica.Mesa;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    
    //Instanciamos los objetos JpaController de cada clase
    FormaDePagoJpaController fdpJpa = new FormaDePagoJpaController();
    CategoriaJpaController catJpa = new CategoriaJpaController();
    MenuJpaController menJpa = new MenuJpaController();
    MesaJpaController mesJpa = new MesaJpaController();
    FacturaJpaController facJpa = new FacturaJpaController();
    DetalleFacturaJpaController dfJpa = new DetalleFacturaJpaController();

    //// Funciones para la clase DetalleFactura ////
    
        //Traer detalles de factura de una factura específica
        public ArrayList<DetalleFactura> traerDetallesDeFactura(int numeroFactura){
            List<DetalleFactura> lis = dfJpa.traerDetallesDeFactura(numeroFactura);
            ArrayList<DetalleFactura> lista = new ArrayList<DetalleFactura>(lis);
            return lista;
        }
    
        //Traer detalles de factura para una mesa activa
        public ArrayList<DetalleFactura> traerDetalleFacturaMesa(int numeroMesa){
            List<DetalleFactura> lis = dfJpa.traerDetalleFacturaMesa(numeroMesa);
            ArrayList<DetalleFactura> lista = new ArrayList<DetalleFactura>(lis);
            return lista;
        }
        
        //Traer próximo número de detalle de factura de una factura
        public int traerUltimoDetalleFactura(int numeroFactura){
            return dfJpa.traerUltimoDetalleFactura(numeroFactura);
        }
        
        //Crear DetalleFactura
        public void crearDetalleFactura(DetalleFactura df) throws Exception{
            dfJpa.create(df);
        }
    

    
    ///Funciones para la clase Factura///
    
        //Agregar factura
        public void crearFactura(Factura fac){
            facJpa.create(fac);
        }

        //Traer número de factura actual de la mesa ocupada
        public int traerNumeroDeFactura(int numeroMesa){
            return facJpa.traerNumeroDeFactura(numeroMesa);
        }    
        
        public Factura traerUnaFactura(int numeroFactura){
            return facJpa.findFactura(numeroFactura);
        }
        
        //Editar Factura
        public void editarFactura(Factura fac){
            try{
                facJpa.edit(fac);
            }
            catch(Exception ex){

            }
        }
        
        //Traer todas las facturas
        public ArrayList<Factura> traerFacturas(){
            List<Factura> lis = facJpa.findFacturaEntities();
            ArrayList<Factura> lista = new ArrayList<Factura>(lis);
            return lista;
        }
        
        //Filtro por fecha
        public ArrayList<Factura> filtroFechaFacturas(LocalDateTime fechaDesde, LocalDateTime fechaHasta){
            List<Factura> lis = facJpa.filtroFechaFacturas(fechaDesde, fechaHasta);
            ArrayList<Factura> lista = new ArrayList<Factura>(lis);
            return lista;
        }
        
    
    ///Funciones para la clase Mesa///

        //Agregar Mesa
        public void crearMesa(Mesa mes){
            mesJpa.create(mes);
        }

        //Buscar si existe una mesa en concreto
        public int existeMesa(int numeroMesa){
            return mesJpa.comprobarExistenciaMesa(numeroMesa);
        }

        //Traer todas las mesas de la base de datos
        public ArrayList<Mesa> traerMesas(){
            List<Mesa> lista = mesJpa.findMesaEntities();
            ArrayList<Mesa> lis = new ArrayList<Mesa>(lista);
            return lis;
        }

        //Traer una sola mesa
        public Mesa traerUnaMesa(int numeroMesa){
            return mesJpa.findMesa(numeroMesa);
        }

        //Editar mesa
        public void editarMesa(Mesa me){
            try{
                mesJpa.edit(me);
            }
            catch(Exception ex){

            }
        }
    
    
    
    ///Funciones para la clase FormaDePago///
    
        //Agregar forma de pago
        public void crearFormaDePago(FormaDePago fdp) {
            fdpJpa.create(fdp);
        }

        //Traer formas de pago
        public ArrayList<FormaDePago> traerFormaDePago(){
            List<FormaDePago> lis = fdpJpa.findFormaDePagoEntities();
            ArrayList<FormaDePago> lista = new ArrayList<FormaDePago>(lis);
            return lista;
        }

        //Traer una sola forma de pago
        public FormaDePago traerUnaFormaDePago(int id){
            return fdpJpa.findFormaDePago(id);
        }

        //Edita el Fdp
        public void editarFdp(FormaDePago fdp){
            try{
                fdpJpa.edit(fdp);
            }
            catch(Exception ex){

            }
        }
    
        //Traer una forma de pago según su nombre
        public FormaDePago traerUnaFormaDePagoPorNombre(String nombre){
            return fdpJpa.traerUnaFormaDePagoPorNombre(nombre);
        }
    
    
    ///Funciones para la clase Categoria///
    
        //Agregar categoría
        public void crearCategoria(Categoria cat){
            catJpa.create(cat);
        }

        //Traer una lista con todas las categorías
        public ArrayList<Categoria> traerCategorias(){
            List<Categoria> lista = catJpa.findCategoriaEntities();
            ArrayList<Categoria> lis = new ArrayList<Categoria>(lista);
            return lis;
        }

        //Traer una Categoría según su ID
        public Categoria traerUnaCategoria(int id){
            return catJpa.findCategoria(id);
        }


        //Traer una categoría según su nombre
        public Categoria traerCategoriaSegunNombre(String nombre){
            return catJpa.traerCategoriaPorNombre(nombre);
        }


        //Editar categoría
        public void editarCategoria(Categoria cat){
            try{

                catJpa.edit(cat);

            }
            catch(Exception ex){

            }

        }
    
    
    
    
    ///Funciones para la clase Menu///
    
        //Agregar menú
        public void crearMenu(Menu men){
            menJpa.create(men);
        }

        //Traer todo del menú
        public ArrayList<Menu> traerMenu(){
            List<Menu> lis = menJpa.findMenuEntities();
            ArrayList<Menu> lista = new ArrayList<Menu>(lis);
            return lista;
        }

        //Traer un producto específico del menú
        public Menu traerUnMenu(int id){
            return menJpa.findMenu(id);
        }

        //Editar producto específico del menú
        public void editarMenu(Menu men){
            try{
                menJpa.edit(men);
            }
            catch(Exception ex){

            }

        }

        //Traer una categoría según su nombre
        public Menu traerUnMenuSegunNombre(String nombre){
            return menJpa.traerUnMenuSegunNombre(nombre);
        }


    }
