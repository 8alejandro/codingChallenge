# Reto: Juego de la ruleta

## Cómo resolver esta prueba técnica

- Sube el código entregado a un github público, a la rama main de un repositorio.
- Realiza los cambios requeridos en una rama de dicho repositorio.
- ¡No dudes en preguntarnos cualquier duda que tengas!

## Descripción

El proyecto consiste en una versión simplificada del juego de la ruleta, el cual permite realizar dos tipos de apuesta:
a un número o a un color. Existe un único usuario en el sistema, el cual puede depositar o retirar dinero, y consultar
la cantidad actual. El juego se inicia en cuanto el usuario realiza la apuesta, y en función del resultado, si la apuesta
es ganadora el usuario cobrará la cantidad asociada al premio.

La aplicación cuenta con 3 endpoints:

* GET /api/user/cash => consultar dinero del usuario
* POST /api/roulette/bet-number => apostar a un número
* POST /api/roulette/bet-color => apostar a un color

En base a esto, se requiere realizar las siguientes tareas:

## Resolver bugs

El test PlaceRouletteBetHandlerTest.notEnoughCashExceptionWhenLosingColorBet está fallando, lanza una excepción incorrecta. El 
código del test es correcto, tu tarea es modificar el código de la aplicación para que el test pase correctamente.

El test PlaceRouletteBetHandlerTest.play también está fallando, el código del test es correcto, hay que resolver el problema en el 
código.

## Crear endpoint para añadir crédito

Existe un caso de uso ya implementado para añadir crédito (depositCash) que está funcionando correctamente, pero no 
tenemos un endpoint rest para invocarlo. Crea el controlador correspondiente (un endpoint en el API rest).

## Implementar tests

En la clase PlaceRouletteBetHandlerTest faltan dos implementaciones, completalas.

## Para pensar (Se preguntará en la entrevista):

- ¿Cómo implementarias otro tipo de apuesta, por ejemplo apostar a un tercio de la ruleta?
- ¿Cómo harias para que se pudiesen hacer varias apuestas simultaneamente?
- ¿Qué cambios harian falta para permitir multiusuario?
- ¿Qué harías para persistir la cantidad de efectivo de un usuario?
- ¿Cómo documentarias el API y cómo mantendrías dicha documentación al día en caso de actualizar la aplicación?

## Tareas opcionales

En esta implementacion hemos usado rojo par, negro impar. 
- Modifica esta implementación para que los colores coincidan con la ruleta real.
- Crea los test unitarios de la clase RoulettePosition

## Requisitos mínimos

- La aplicación debe funcionar
- Todos los test deben pasar

