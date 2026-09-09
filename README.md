# Sistema de Control de Acceso a una Colonia Privada

Prueba de concepto desarrollada en Java para administrar residentes, visitantes y movimientos de entrada y salida de una colonia privada.

## Funciones

- Alta de residentes.
- Modificacion de residentes.
- Baja de residentes.
- Asignacion de casa o departamento.
- Registro de visitantes.
- Tipos de visitante: Familia, Proveedor, Taxi u Otro.
- Registro de entradas y salidas.
- Bitacora con fecha y hora de cada movimiento.

## Estructura

- `src/Main.java`: menu y funcionamiento principal.
- `src/Residente.java`: datos de los residentes.
- `src/Visitante.java`: datos de los visitantes.
- `src/Registro.java`: movimientos de entrada y salida para la bitacora.

## Como ejecutarlo

Desde una terminal ubicada en la carpeta del proyecto:

```bash
javac src/*.java
java -cp src Main
```

## Flujo de ejemplo

1. Registrar un residente y asignarle casa/departamento.
2. Registrar un visitante indicando si es familiar, proveedor, taxi u otro.
3. Indicar a quien visita.
4. Registrar su entrada.
5. Registrar su salida.
6. Consultar la bitacora.

## Prueba de concepto

El objetivo es demostrar de forma sencilla como un sistema puede controlar quienes viven en una colonia y llevar un registro de las personas externas que entran y salen.
