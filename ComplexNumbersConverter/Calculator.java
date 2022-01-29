package hr.fer.oop.swingZadaci.zad4;

public class Calculator {
    //modul, kut
    public static double[] toPolar(double real, double imag) {
        double[] result = new double[2];
        result[0] = Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
        result[1] = Math.atan(imag/real) * 180 / Math.PI;
        return result;
    }

    public static double[] toRectg(double module, double angle) {
        double[] result = new double[2];
        angle = angle * Math.PI / 180;
        result[0] = module * Math.cos(angle);
        result[1] = module * Math.sin(angle);
        return result;
    }
}
