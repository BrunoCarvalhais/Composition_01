package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String name;
    private WorkerLevel level;
    private Double basesalary;

    // Atributos --> Composição
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double basesalary, Department department) {
        this.name = name;
        this.level = level;
        this.basesalary = basesalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(Double basesalary) {
        this.basesalary = basesalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }


    //Adicionando um contrato na lista de contratos
    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    //Removendo o contrato da lista de contratos
    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    //Método de cálculo de quanto o trabalhador ganhou em um ano e no mês
    public double income(int year, int month){
        double sum = basesalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month){
                sum += c.totalValue();
            }
        }
        return sum;
    }
}