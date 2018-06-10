package mainapp;

import activationfunctions.ActivationFunction;
import activationfunctions.SigmoidalActivationFunction;
import basics.Network;
import plotter.DrawPlot;

import java.util.ArrayList;
import java.util.Collections;

public class MyApp {
    private static ActivationFunction function = new SigmoidalActivationFunction();

    public static void main(final String[] args) {

        Network siec = new Network(true ,function,4,4,2,0.4,0);

        double[][] wejscieTest = { {0,0,1,0},  {1,0,0,0}, {0,0,0,1}, {0,1,0,0} };
        double[][] wyjscieTest = new double[4][4];

        siec.Calculate(wejscieTest[0]);

        int EPOKI = 1000;

        double wejsce1[] = {1,0,0,0};
        double wejsce2[] = {0,1,0,0};
        double wejsce3[] = {0,0,1,0};
        double wejsce4[] = {0,0,0,1};

        double[][] error1 = new double[EPOKI][2];
        double[][] error2 = new double[EPOKI][2];
        double[][] error3 = new double[EPOKI][2];
        double[][] error4 = new double[EPOKI][2];
        double[][] errorAll = new double[EPOKI][2];

        ArrayList<double[]> wejsca = new ArrayList<>();
        wejsca.add(wejsce1);
        wejsca.add(wejsce2);
        wejsca.add(wejsce3);
        wejsca.add(wejsce4);

        for (int i=0;i<EPOKI;i++){
            Collections.shuffle(wejsca);

            error1[i][0] = i;
            error1[i][1] = siec.Learn(wejsca.get(0),wejsca.get(0));
            error2[i][0] = i;
            error2[i][1] = siec.Learn(wejsca.get(1),wejsca.get(1));
            error3[i][0] = i;
            error3[i][1] = siec.Learn(wejsca.get(2),wejsca.get(2));
            error4[i][0] = i;
            error4[i][1] = siec.Learn(wejsca.get(3),wejsca.get(3));

            errorAll[i][0] = i;
            errorAll[i][1] = (error1[i][1]+error2[i][1]+error3[i][1]+error4[i][1])/4;
        }


        System.out.println("Dane wejsciwe");
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++){
                System.out.print(wejscieTest[i][j]+ ",    ");
            }
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            wyjscieTest[i] = siec.Calculate(wejscieTest[i]);
        }

        System.out.println("Dane wyjsciowe");
        for (int i=0;i<4;i++) {
            for (int j=0;j<4;j++){
                System.out.print(wyjscieTest[i][j]+ ",    ");
            }
            System.out.println();
        }

        //DrawPlot.draw(error1,error2,error3,error4,EPOKI);
        DrawPlot.draw(errorAll,EPOKI);


    }
}
