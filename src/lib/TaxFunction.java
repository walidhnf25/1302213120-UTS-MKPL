package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	private static final int TAX_RATE = 5;
    private static final int MAX_CHILDREN = 3;
    private static final int SINGLE_TAX_THRESHOLD = 54000000;
    private static final int MARRIED_TAX_THRESHOLD = 58500000;
    private static final int CHILD_TAX_ALLOWANCE = 1500000;
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }
		
		if (numberOfChildren > MAX_CHILDREN) {
            numberOfChildren = MAX_CHILDREN;
        }
		
		int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int taxThreshold = isMarried ? MARRIED_TAX_THRESHOLD : SINGLE_TAX_THRESHOLD;
        int totalDeductions = deductible + taxThreshold + (isMarried ? numberOfChildren * CHILD_TAX_ALLOWANCE : 0);

		tax = (int) Math.round(5 * 0.01 * (totalIncome - totalDeductions));

		return Math.max(tax, 0);
			 
	}
	
}
