# M9-UF2
UF2: Processos y fils

#09-El sopar dels filòsofs 3 (amb Lock)
CONCEPTE CLAU
L'idea es simular a diferents filofos que pensen i menjen, pero per menjar necesiten dues forquilles. Pero les forquilles son compartides amb els altres filosof, el que pot portar condicions de carrera o deadlocks.
Per poder evitar aquest bloquejos i asegura una correcta sincornitzció, utilitzarem ReentrantLock, una clase Java per portar exclusions mutues en recursos compartits.

CLASSES
1- Forquilla: Representa la forquilla amb la que el filosof menja, amb un ReentrantLock per bloquejar quan un filosf l'utilitza.

2- Filosof: Represnta a cada filósof, el qual intentara agafar dos forquilles per menjar i després els allivera.

3- Taula: Administra els filosofs i les forquilles.