# GaltonBoard

Realizacion de un Tablero de Galton utilizando la Programacion Concurrente.

Requisitos:

-Cada estación de trabajo de la fábrica es un hilo de ejecución independiente. Estos hilos deben coordinarse entre sí para asegurar que los componentes de la máquina se produzcan en el orden correcto y en las cantidades correctas para el ensamblaje final.

-Implementa un mecanismo de sincronización para garantizar que los componentes de la máquina se produzcan y ensamblen de manera ordenada. Esto puede implicar el uso de locks, semáforos, o variables de condición.

-Implementa la producción y el ensamblaje de la máquina como un problema de productor-consumidor. Las estaciones de trabajo que producen componentes son los productores, y la línea de ensamblaje es el consumidor.

-Usa un modelo de memoria compartida para permitir la comunicación entre los hilos. Los componentes producidos por las estaciones de trabajo deben colocarse en un búfer compartido del que la línea de ensamblaje pueda retirarlos.

-Implementa la distribución de las tareas de producción entre las estaciones de trabajo utilizando un algoritmo de scheduling. Puede ser round-robin, prioridad, más corto primero, etc.

-Usa técnicas de programación paralela y distribuida para acelerar el proceso de producción. Esto puede implicar la distribución de la carga de trabajo entre varios procesadores o nodos de un sistema distribuido.
