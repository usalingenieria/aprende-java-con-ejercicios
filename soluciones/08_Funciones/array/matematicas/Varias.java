package matematicas;

public class Varias {


  /*************************************************************/
  /*                                                           */
  /* boolean esCapicua(long x)                                 */
  /* boolean esCapicua(int x)                                  */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Devuelve verdadero si el número que se pasa como          */
  /* parámetro es capicúa y falso en caso contrario.           */
  /*                                                           */
  /*************************************************************/

  public static boolean esCapicua(long x) {
    
    return x == voltea(x);  
  }
    
  public static boolean esCapicua(int x) {
    
    return esCapicua((long)x);  
  }
  


  /*************************************************************/
  /*                                                           */
  /* boolean esPrimo(int x)                                    */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Devuelve verdadero si el número que se pasa como          */
  /* parámetro es primo y falso en caso contrario.             */
  /*                                                           */
  /*************************************************************/
  
  public static boolean esPrimo(int x) {
    
    for (int i = 2; i < x; i++)
      if ((x % i) == 0) return false;
    
    return true;  
  }


  /*************************************************************/
  /*                                                           */
  /* int siguientePrimo(int x)                                 */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Devuelve el menor primo que es mayor al número que se     */
  /* pasa como parámetro.                                      */
  /*                                                           */
  /*************************************************************/
  
  public static int siguientePrimo(int x) {
  
    while (!esPrimo(++x));
    
    return x;  
  }
  
  
  
  /*************************************************************/
  /*                                                           */
  /* double potencia(int base, int exponente)                  */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Dada una base y un exponente devuelve la potencia.        */
  /*                                                           */
  /*************************************************************/
  
  public static double potencia(int base, int exponente) {
    
    if (exponente == 0)
      return 1;
    
    if (exponente < 0)
      return 1/potencia(base, -exponente);
    
    int n = 1;
    for (int i = 0; i < Math.abs(exponente); i++)
      n = n * base;
    
    return n;
  }  



  /*************************************************************/
  /*                                                           */
  /* int digitos(long x)                                       */
  /* int digitos(int x)                                        */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Cuenta el número de dígitos de un número entero.          */
  /*                                                           */
  /*************************************************************/
    
  public static int digitos(long x) {

    if (x < 0)
      x = -x;
      
    if (x == 0)
      return 1;
        
    else {
      int n = 0;
      while (x > 0) {
        x = x / 10;
        n++;
      }
      return n;
    }
  }
    
  public static int digitos(int x) {
  
    return digitos((long)x);
  }
  
  

  /*************************************************************/
  /*                                                           */
  /* long voltea(long x)                                       */
  /* int voltea(int x)                                         */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Le da la vuelta a un número.                              */
  /*                                                           */
  /*************************************************************/
    
  public static long voltea(long x) {
    
    if (x < 0)
      return -voltea(-x);
      
    long volteado = 0;
    
    while(x > 0) {
      volteado = (volteado * 10) + (x % 10);
      x = x / 10;
    }
    
    return volteado;
  }

  public static int voltea(int x) {
    
    return (int)voltea((long)x);    
  }
  

  /*************************************************************/
  /*                                                           */
  /* int digitoN(long x, int n)                                */
  /* int digitoN(int x, int n)                                 */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Devuelve el dígito que está en la posición n de un número */
  /* entero. Se empieza contando por el 0 y de izquierda a     */
  /* derecha.                                                  */
  /*                                                           */
  /*************************************************************/
    
  public static int digitoN(long x, int n) {
    
    x = voltea(x);
    
    while (n-- > 0)
      x = x / 10;
    
    return (int)x % 10;
  }

  public static int digitoN(int x, int n) {
    
    return digitoN((long)x, n);
  }
  
  
  /*************************************************************/
  /*                                                           */
  /* int posicionDeDigito(long x, int d)                       */
  /* int posicionDeDigito(int x, int d)                        */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Da la posición de la primera ocurrencia de un dígito      */
  /* dentro  de un número entero. Si no se encuentra,          */
  /* devuelve -1.                                              */
  /*                                                           */
  /*************************************************************/
    
  public static int posicionDeDigito(long x, int d) {
    
    int i;
    
    for (i = 0; (i < digitos(x)) && (digitoN(x, i) != d); i++);
    
    if (i == digitos(x))
      return -1;
    else
      return i;
  }
  
  public static int posicionDeDigito(int x, int d) {
    
    return posicionDeDigito((long)x, d);
  }
  
  
  
  /*************************************************************/
  /*                                                           */
  /* long quitaPorDetras(long x, int n)                        */
  /* int quitaPorDetras(int x, int n)                          */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Le quita a un número n dígitos por detrás (por la         */
  /* derecha).                                                 */
  /*                                                           */
  /*************************************************************/
    
  public static long quitaPorDetras(long x, int n) {
    
    return x / (long)potencia(10, n);
  }
    
  public static int quitaPorDetras(int x, int n) {
    
    return (int)quitaPorDetras((long) x, n);
  }



  /*************************************************************/
  /*                                                           */
  /* long quitaPorDelante(long x, int n)                       */
  /* int quitaPorDelante(int x, int n)                         */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Le quita a un número n dígitos por delante (por la        */
  /* izquierda).                                               */
  /*                                                           */
  /*************************************************************/
    
  public static long quitaPorDelante(long x, int n) {
    
    x = pegaPorDetras(x, 1); // "cierra" el número por si acaso termina en 0    
    x = voltea(quitaPorDetras(voltea(x), n));
    x = quitaPorDetras(x, 1);
    return x;
  }

  public static int quitaPorDelante(int x, int n) {
    
    return (int)quitaPorDelante((long)x, n);
  }
  

  /*************************************************************/
  /*                                                           */
  /* long pegaPorDetras(long x, int d)                         */
  /* int pegaPorDetras(int x, int d)                           */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Añade un dígito a un número por detrás.                   */
  /*                                                           */
  /*************************************************************/
    
  public static long pegaPorDetras(long x, int d) {
    
    return juntaNumeros(x, d);
  }
  
  public static int pegaPorDetras(int x, int d) {
    
    return (int)pegaPorDetras((long)x, d);
  }
    
  

  /*************************************************************/
  /*                                                           */
  /* long pegaPorDelante(long x, int d)                        */
  /* int pegaPorDelante(int x, int d)                          */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Añade un dígito a un número por delante.                  */
  /*                                                           */
  /*************************************************************/
    
  public static long pegaPorDelante(long x, int d) {
    
    return juntaNumeros(d, x);
  }
    
  public static int pegaPorDelante(int x, int d) {
    
    return (int)pegaPorDelante((long)x, d);
  }

  /*************************************************************/
  /*                                                           */
  /* long trozoDeNumero(long x, int inicio, int fin)           */
  /* int trozoDeNumero(int x, int inicio, int fin)             */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Toma como parámetros las posiciones inicial y final       */
  /* dentro de un número y devuelve el trozo correspondiente.  */
  /*                                                           */
  /*************************************************************/
    
  public static long trozoDeNumero(long x, int inicio, int fin) {
    
    int longitud = digitos(x);
    x = quitaPorDelante(x, inicio);
    x = quitaPorDetras(x, longitud - fin - 1);
    return x;
  }

  public static int trozoDeNumero(int x, int inicio, int fin) {
    
    return (int)trozoDeNumero((long)x, inicio, fin);
  }


  /*************************************************************/
  /*                                                           */
  /* long juntaNumeros(long x, long y)                         */
  /* int juntaNumeros(int x, int y)                            */
  /*                                                           */
  /*************************************************************/
  /*                                                           */
  /* Pega dos números para formar uno.                         */
  /*                                                           */
  /*************************************************************/
    
  public static long juntaNumeros(long x, long y) {
    
    return (long)(x * potencia(10, digitos(y))) + y;
  }
  
  public static int juntaNumeros(int x, int y) {
    
    return (int)(juntaNumeros((long)x, (long)y));
  }
  
}
