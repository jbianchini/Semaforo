import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Semaphore

class AccesoRecurso(private val semaforo: Semaphore, private val nombre: String) {
    suspend fun acceder() {
        try {
            // Solicitar un permiso al semáforo
            semaforo.acquire()

            // Acceder al recurso compartido o realizar trabajo crítico
            println("$nombre está accediendo al recurso compartido.")

            // Simular trabajo
            delay(2000)

            // Liberar el permiso cuando se ha terminado de usar el recurso
            semaforo.release()
            println("$nombre ha liberado el recurso.")
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}