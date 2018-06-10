package activationfunctions;

public class SigmoidalActivationFunction implements ActivationFunction {
    @Override
    public double Value(double arg) {

        return (1 / (1 + (Math.exp(-arg))));
    }

    @Override
    public double Derivative(double arg) {
        return (Value(arg) * (1 - Value(arg)));
    }
}
