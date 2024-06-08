import java.util.Arrays;

public class DatosNoagrupaods {


    public DatosNoagrupaods(){}

    public double getMedia(double[] datos) {
        // Variable para almacenar la suma de los datos
        double suma = 0;

        // Suma de todos los valores en el array
        for (double dato : datos) {
            suma += dato;
        }

        // Dividir la suma por el número total de datos para obtener la media
        double media = suma / datos.length;

        return media;
    }


    public double getMediana(double[] datos) {
        // Primero ordenamos los datos
        Arrays.sort(datos);

        int n = datos.length;
        double mediana;

        // Verificamos si el número de datos es impar
        if (n % 2 != 0) {
            mediana = datos[n / 2];
        } else {
            // Si es par, calculamos el promedio de los dos valores centrales
            int indice1 = n / 2 - 1;
            int indice2 = n / 2;
            mediana = (datos[indice1] + datos[indice2]) / 2.0;
        }

        return mediana;
    }

    public double getModa(double[] datos) {
        // Ordenar el array para facilitar el cálculo de la moda
        Arrays.sort(datos);

        double moda = Double.NaN; // Valor por defecto si no hay moda
        int maxFrecuencia = 0;
        int frecuenciaActual = 1;

        // Recorrer el array para encontrar el valor con la frecuencia más alta
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] == datos[i - 1]) {
                frecuenciaActual++;
            } else {
                frecuenciaActual = 1;
            }

            if (frecuenciaActual > maxFrecuencia) {
                moda = datos[i];
                maxFrecuencia = frecuenciaActual;
            }
        }

        return moda;
    }
}