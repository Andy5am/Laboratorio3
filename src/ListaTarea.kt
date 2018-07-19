package main


fun MenuNuevo():String{
    return """
        MENU:
            1.Crear lista de tareas
            2.Salir
    """.trimIndent()
}
fun MenuSeleccionar():String{
    return """
        MENU:
            1.Crear lista de tareas
            2.Ver todas las listas de tareas
            3.Seleccionar una lista de tareas
            4.Salir
    """.trimIndent()
}
fun MenuSeleccionado():String{
    return """
        MENU:
            1.Deseleccionar lista actual
            2.Agregar una tarea
            3.Completar una tarea
            4.Ver todas las tareas en esta lista
            5.Salir
    """.trimIndent()
}

fun main (args: Array<String>){
    val lista = Lista("Tareas")
    var seguir :Boolean = true
    val nada= "HOla"
    val x = Tarea(nada)
    do{
        if (lista.findTarea(x)==null){
            println(MenuNuevo())
            println("Ingrese el numero de opcion:")
            var option = readLine()!!.toInt()
            when (option) {
                1 -> {
                    println("Ingrese el nombre de su nueva lista:")
                    var listatarea = readLine()!!
                    var listatarea = Tarea(listatarea)
                    lista.addTarea(listatarea)
                    var continuar: Boolean = true
                    do {


                        println(MenuSeleccionar())
                        println("Ingrese el numero de opcion")
                        var option2 = readLine()!!.toInt()
                        when (option2) {
                            1 -> {
                                println("Ingrese el nombre de su nueva lista:")
                                var listatarea = readLine()!!
                                var filteredtareas = lista.filter { it.nombre == listatarea }
                                if (filteredtareas.count() == 0) {
                                    var listatarea = Tarea(listatarea)
                                    lista.add(listatarea)
                                } else {
                                    println("Ya existe esa lista de tareas")
                                }
                            }
                            2 ->{
                                prinln(lista.nombre)


                            }
                        }
                    } while (continuar)
                }
                2-> {

                }
            }

        }

    } while (seguir)







}
class Lista (
        val nombre:String,
        val ListadeTareas: ArrayList<Tarea> = ArrayList()
){
    fun findTarea (nombre:String):Tarea? {
        var filteredtareas = ListadeTareas.filter { it.nombre == nombre }
        if (filteredtareas.count() > 0) {
            return filteredtareas[0]
        }

        return null
    }
    fun listavacia(){
        ListadeTareas.isEmpty()
    }
    fun addTarea(tarea: Tarea): Boolean {
        if(findTarea(tarea.nombre) == null) {
            ListadeTareas.add(tarea)
            return true
        }

        return false
    }
    override fun toString():String{
        return """
            nombre:$nombre
            Tareas: $ListadeTareas
        """.trimIndent()
    }
}




class Tarea (
        val nombre: String,
        private val ListaObjetivos: ArrayList<Objetivo> = ArrayList()
        ){
    override fun toString(): String {
        return """
            Nombre: $nombre
            Objetivos: $ListaObjetivos
        """.trimIndent()
    }

}



class Objetivo (
        private val nombre: String
){

}