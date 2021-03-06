package src.se.kth.iv1350.POS.view;

import src.se.kth.iv1350.POS.model.SaleObserver;

public abstract class TotalRevenueDisplay implements SaleObserver {
    private double totalRevenue;

    protected TotalRevenueDisplay() {
        totalRevenue = 0;
    }

    @Override
    public void newSale(double priceOfTheSale) {
        calculateTotalIncome(priceOfTheSale);

        showTotalIncome();
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome(totalRevenue);
        } catch(Exception e) {
            handleErrors(e);
        }
    }

    private void calculateTotalIncome(double priceOfTheSale) {
        totalRevenue += priceOfTheSale;
    }

    protected abstract void doShowTotalIncome(double totalRevenue) throws Exception;

    protected abstract void handleErrors(Exception e);
}
