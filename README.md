# CriptografiaBasicaJava
## Juan Ocampo

Programa de ejemplo para criptografía simétrica, asimétrica y sistema de encriptación rsa.

La criptografía es la ciencia que estudia las formas de ocultar mensajes para que estos puedan ser transmitidos a través de un canal inseguro,
como puede ser internet, un servicio de correo, entre otros.

Se tienen 2 tipos de criptografía comunmente usados en informática y computación los cuales son: 

* Criptografía Simétrica
* Criptografía Asimétrica

En esta ocasión nos enfocaremos en criptografía simétrica, la cual es la ms básica de todas.

## Criptografía Simétrica

Este tipo de criptografía se basa en la idea de que se cuenta con una clave númerica, la cual se asocia a un mensaje a transmitir
de forma que cada caracter que compone el mensaje está relacionado con un número de la clave; si el mensaje es mas largo que la clave,
entonces se repite la misma secuencia de clave hasta ocupar y relacionar todos los caracteres que componen el mensaje.

### Ejemplo:

Supongamos que tenemos el mensaje compuesto por la palabra "Hola" y deseamos encriptar de manera simétrica. Nuestra clave de ejemplo
será: 123

Para este caso tendremos:

* H -> 1 -> I
* o -> 2 -> q
* l -> 3 -> o
* a -> 1 -> b

Como podemos ver, y de acuerdo a la clave suministrada, obtendremos una cadena encriptada la cual es:
* Iqob
la cual equivale al mensaje
* Hola
con clave de encriptación
*123

De este ejemplo es fácil deducir que la técnica consiste en desplazar a través del código ASCII cada caracter del mensaje, tantas posiciones a la derecha
como lo indique el número relacionado de la clave asignada. Por supuesto este proceso es reversible y para obtener nuevamente la cadena de 
texto original (mensaje), aplicamos la misma clave pero esta vez desplaamos tantas posiciones como se indique a la IZQUIERDA, esto es, devol-
viendonos en la tabla del código ASCII. En nuestro ejemplo tendremos:

* I -> 1 -> H
* q -> 2 -> o
* o -> 3 -> l
* b -> 1 -> a

Una vez hemos explicado la teoría base, vamos a ver esto aplicado a un ejemplo en java. El código es posible descargarlo desde el enlace a continuación:

* [Código Ejemplo](https://github.com/jpocampor/CriptografiaBasicaJava/tree/feature/criptografiaSimetrica) - Criptografía Simétrica

Pronto se dará un ejemplo de criptografía Asimétrica.
