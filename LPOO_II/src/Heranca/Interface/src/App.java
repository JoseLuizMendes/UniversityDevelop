public class App {
    public static void main(String[] args) throws Exception {
        // testando Circulo
        Circulo circulo = new Circulo(10, 20, 5);
        System.out.println(circulo.desenhar());
        System.out.printf("Área: %.2f\n", circulo.area());
        System.out.printf("Perímetro: %.2f\n", circulo.perimetro());

        circulo.redimensionar(2);
        System.out.println("Após redimensionar:");
        System.out.println(circulo.desenhar());
        System.out.printf("Área: %.2f\n", circulo.area());
        System.out.printf("Perímetro: %.2f\n", circulo.perimetro());
        System.err.println("--------------------------------------------");
        // testando Retangulo
        Retangulo retangulo = new Retangulo(30, 40, 10, 20);
        System.out.println(retangulo.desenhar());
        System.out.printf("Área: %.2f\n", retangulo.area());
        System.out.printf("Perímetro: %.2f\n", retangulo.perimetro());
        retangulo.redimensionar(1.5);
        System.out.println("Após redimensionar:");
        System.out.println(retangulo.desenhar());
        System.out.printf("Área: %.2f\n", retangulo.area());
        System.out.printf("Perímetro: %.2f\n", retangulo.perimetro());
        
        System.err.println("--------------------------------------------");
        // testando quadrado
        Quadrado quadrado = new Quadrado(4, 4, 4 );
        System.out.println(quadrado.desenhar());
        System.out.printf("Área: %.2f\n", quadrado.area());
        System.out.printf("Perímetro: %.2f\n", quadrado.perimetro());
        quadrado.redimensionar(1.5);
        System.out.println("Após redimensionar:");
        System.out.println(quadrado.desenhar());
        System.out.printf("Área: %.2f\n", quadrado.area());
        System.out.printf("Perímetro: %.2f\n", quadrado.perimetro());
    }
}
