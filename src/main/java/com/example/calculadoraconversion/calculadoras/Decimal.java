package com.example.calculadoraconversion.calculadoras;

import java.util.ArrayList;

public class Decimal {
    public StringBuilder valor = new StringBuilder();

    public void decimalToBinary(int decimalNumber, ArrayList<String> pasosDecimalToBinary) {
        if (decimalNumber == 0) {

            valor.append(0);

            pasosDecimalToBinary.add("Dividimos " + decimalNumber + "/2 \nSi nuestro resultado no es un numero " +
                    "entero agregamos un uno \nen otro caso sera cero \nen esta caso no tenemos resideo por ende tenemos " + 0 + "\nStack de valores: " + valor.toString() );
            pasosDecimalToBinary.add("Ahora le damos la vuelta y tenemos el resultado " + valor.reverse().toString());
        } else if (decimalNumber == 1) {
            double resideo = (double) decimalNumber / 2;

            valor.append(1);

            pasosDecimalToBinary.add("Dividimos " + decimalNumber + "/2 \nSi nuestro resultado no es un numero " +
                    "entero agregamos un uno \nen otro caso sera cero \nen esta caso tenemos " + resideo + " por ende tenemos " + 1 + "\nStack de valores: " + valor.toString());
            pasosDecimalToBinary.add("Ahora le damos la vuelta y tenemos el resultado " + valor.reverse().toString());
        } else {
            int remainder = decimalNumber % 2;
            int quotient = decimalNumber / 2;
            double resideo = (double) decimalNumber / 2;

            valor.append(remainder);


            pasosDecimalToBinary.add("Dividimos " + decimalNumber + "/2 \nSi nuestro resultado no es un numero " +
                    "entero agregamos un uno \nen otro caso sera cero \nen esta caso tenemos " + resideo + " por ende tenemos " + remainder + "\nStack de valores: " + valor.toString());

            decimalToBinary(quotient, pasosDecimalToBinary);

        }
    }


    public void decimalToOctal(int decimalNumber, ArrayList<String> pasosDecimalToOctal ) {
        if (decimalNumber == 0) {

            valor.append(0);
            pasosDecimalToOctal.add("El número decimal es 0, por lo tanto, el octal también es 0.");
        } else {
            while (decimalNumber != 0) {
                int remainder = decimalNumber % 8;
                int quotient = decimalNumber / 8;

                valor.append(remainder);

                double resideo = (double) decimalNumber / 8;
                pasosDecimalToOctal.add("Dividimos " + decimalNumber + "/8 \nSi nuestro resultado no es un número entero, agregamos un residuo \nen otro caso, será cero \nEn este caso tenemos " + resideo + ", por lo tanto, el residuo es " + remainder + "\nStack de valores: " + valor.toString());

                decimalNumber = quotient;
            }
        }
    }


    public void decimalToHexadecimal(int decimalNumber, ArrayList<String> pasosDecimalToHex) {
        if (decimalNumber == 0) {
            pasosDecimalToHex.add("El número decimal es 0, por lo tanto, el hexadecimal también es 0.");
        } else {
            while (decimalNumber != 0) {
                int remainder = decimalNumber % 16;
                int quotient = decimalNumber / 16;
                double resideo = (double) decimalNumber / 16;

                // Convertir los valores mayores a 9 a caracteres hexadecimales
                String hexChar = (remainder < 10) ? String.valueOf(remainder) : Character.toString((char) ('A' + remainder - 10));


                // Agregar los pasos explicativos a pasosDecimalToHex
                String paso = "Dividimos " + decimalNumber + " entre 16.\nSi el resultado no es un número entero, agregamos el residuo.\nEn este caso, " + resideo + " es el resultado, por lo que el residuo es ";
                if (remainder < 10) {
                    paso += remainder + ".\n";
                } else {
                    paso += "'" + hexChar + "'.\n";
                }
                pasosDecimalToHex.add(paso);

                decimalNumber = quotient;
            }
        }
    }

}
