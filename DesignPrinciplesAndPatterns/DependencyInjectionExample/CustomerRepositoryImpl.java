package DesignPrinciplesAndPatterns.DependencyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        // Simulating database records
        if (id == 101) {
            return "Raja";
        } else if (id == 102) {
            return "Kiran";
        } else if (id == 103) {
            return "Sai";
        }

        return "Customer Not Found";
    }
}