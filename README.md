# Threads


A) La interfaz Runnable representa una Tarea que puede ejecutarse por Hilo simple o Ejecutores o por cualquier otro medio. la separación lógica de Tarea como Ejecutable que Hilo es una buena decisión de diseño.
Separar tarea como Runnable significa que podemos reutilizar la tarea y también tenemos libertad para ejecutarla desde diferentes medios.

 La herencia de todos los métodos Thread conlleva una sobrecarga adicional solo para representar una tarea que se puede hacer fácilmente con Runnable.
Conviene usar Thread para tareas más largas que requieren comunicación entre el subproceso de trabajo Y el hilo de la persona que llama
La mayor diferencia es que  Thread.start() inicia un hilo que llama al run() método, mientras Runnable.run() solo llama al run() método en el hilo actual.

B) Ciclo de vida:
1. Nuevo (New): El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start().

2. Ejecutable : El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3. Bloqueado : El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en este estado, no se le asigna tiempo de CPU.

4. Muerto (Dead): La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread.

C)

start: Este método indica al intérprete de Java que cree un contexto del hilo del sistema y comience a ejecutarlo. A continuación, el método run() de este hilo será invocado en el nuevo contexto del hilo. 

sleep: El método sleep() provoca que el intérprete ponga al hilo en curso a dormir durante el número de milisegundos que se indiquen en el parámetro de invocación. Una vez transcurridos esos milisegundos, dicho hilo volverá a estar disponible para su ejecución.

yield: Este método hace que el intérprete cambie de contexto entre el hilo actual y el siguiente hilo ejecutable disponible. Es una manera de asegurar que nos hilos de menor prioridad no sufran inanición.

join: Este método permite a un hilo quedar a la espera que termine un segundo hilo. El método join() suele utilizarse para mantener un orden en la secuencia de los hilos.
