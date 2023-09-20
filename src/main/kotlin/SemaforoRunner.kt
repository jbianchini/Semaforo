import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Semaphore

class SemaforoRunner {

    fun comenzarPrueba() = runBlocking {
        // Crear un semáforo con un contador inicial
        val semaforo = Semaphore(2) // Permite 2 permisos simultáneos

        // Hilos que intentarán acceder al recurso compartido
        val hilo1 = async { AccesoRecurso(semaforo, "Hilo 1").acceder() }
        val hilo2 = async { AccesoRecurso(semaforo, "Hilo 2").acceder() }
        val hilo3 = async { AccesoRecurso(semaforo, "Hilo 3").acceder() }

        // Esperar a que todos los hilos terminen
        awaitAll(hilo1, hilo2, hilo3)
    }
}