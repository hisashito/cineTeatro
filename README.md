# cineTeatro
Desarrollo de una aplicación básica ( de consola) para un cine donde las personas puedan comprar boletos, reservar asientos y disfrutar de su noche de cine.

## etapa 1
```
Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
```
## etapa 2

Calcular la ganancia generada por la venta de boletos en función del número de asientos disponibles.
```
Enter the number of rows:
> 4
Enter the number of seats in each row:
> 5
Total income:
$200
```
```
Enter the number of rows:
> 8
Enter the number of seats in each row:
> 9
Total income:
$648
```
## etapa 3

Permite revisar el precio del asiento.
```
//after cinema "initialization"
Enter a row number:
> 3
Enter a seat number in that row:
> 6

Ticket price: $10

Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S B S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S
```
```
//after cinema "initialization"
Enter a row number:
> 6
Enter a seat number in that row:
> 5

Ticket price: $8

Cinema:
  1 2 3 4 5 6 7 8 9
1 S S S S S S S S S
2 S S S S S S S S S
3 S S S S S S S S S
4 S S S S S S S S S
5 S S S S S S S S S
6 S S S S B S S S S
7 S S S S S S S S S
8 S S S S S S S S S
```
## etapa 4 
Incluir un menu para que el usuario decida si comprar más boletos o finalizar el uso de la aplicación.
```
1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S S S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 4
Enter a seat number in that row:
> 5
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S S S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 2

Enter a row number:
> 6
Enter a seat number in that row:
> 6
Ticket price: $10

1. Show the seats
2. Buy a ticket
0. Exit
> 1

Cinema:
  1 2 3 4 5 6 7
1 S S S S S S S
2 S S S S S S S
3 S S S S S S S
4 S S S S B S S
5 S S S S S S S
6 S S S S S B S
7 S S S S S S S

1. Show the seats
2. Buy a ticket
0. Exit
> 0
```
