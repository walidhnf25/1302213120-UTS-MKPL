package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	private LocalDate joinDate;
	private boolean isForeigner;
	private Gender gender;
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
	private String spouseName;
	private String spouseIdNumber;
	private List<String> childNames;
	private List<String> childIdNumbers;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate joinDate, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinDate = joinDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
	}
	
	public void setMonthlySalary(int grade) {
        switch (grade) {
            case 1:
                monthlySalary = 3000000;
                break;
            case 2:
                monthlySalary = 5000000;
                break;
            case 3:
                monthlySalary = 7000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        if (isForeigner) {
            monthlySalary *= 1.5;
        }
    }
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}
	
	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
	
	public int getAnnualIncomeTax() {
        int monthWorkingInYear = joinDate.getMonthValue() == LocalDate.now().getMonthValue() ?
                                 LocalDate.now().getMonthValue() - joinDate.getMonthValue() :
                                 12;
        return TaxCalculator.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
    }
}

enum Gender {
    MALE,
    FEMALE
}

class TaxCalculator {
    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear, int annualDeductible, boolean isSingle, int numberOfChildren) {
        // Tax calculation logic
        return 0; // Placeholder, replace with actual calculation
    }
}