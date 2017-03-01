import java.util.ArrayList;


public class CommonManager {
	//Find common manager in a graph hierarchy, similar to common ancestor but instead of two children in 
	//tree its a list.
	
	public static void main(String[] args){
		Employee milton = new Employee("Milton", null);
		Employee nina = new Employee("Nina", null);
		Employee bob = new Employee("Bob", null);
		Employee porter = new Employee("Porter", null);
		Employee samir = new Employee("Samir", null);
		Employee michael = new Employee("Michael", null);
		
		ArrayList<Employee> peterReports = new ArrayList<Employee>();
		peterReports.add(milton); peterReports.add(nina);
		Employee peter = new Employee("Peter", peterReports);
		
		ArrayList<Employee> domReports = new ArrayList<Employee>();
		domReports.add(peter); domReports.add(bob); domReports.add(porter);
		Employee dom = new Employee("Dom", domReports);
		
		ArrayList<Employee> billReports = new ArrayList<Employee>();
		billReports.add(dom); billReports.add(samir); billReports.add(michael); 
		Employee bill = new Employee("Bill", billReports);
		
		System.out.println(closestCommonManager(bill, milton, nina).getName()); //peter
		System.out.println(closestCommonManager(bill, nina, porter).getName()); //dom
		System.out.println(closestCommonManager(bill, nina, samir).getName()); //bill
		System.out.println(closestCommonManager(bill, peter, nina).getName()); //peter
	}
	
	public static Employee closestCommonManager(Employee root, Employee a, Employee b){
		if(!cover(root,a) || !cover(root,b)) return null;
		return findCommon(root,a,b);
	}
	
	public static Employee findCommon(Employee root, Employee a, Employee b){
		if(root == a || root == b) return root;
		for(int i=0;i<root.report.size();i++){
			Employee checkThisEmpl = root.report.get(i);
			if(cover(checkThisEmpl,a) && cover(checkThisEmpl,b)){
				return findCommon(checkThisEmpl,a,b);
			}
		}
		return root;
	}
	
	public static boolean cover(Employee root, Employee n){
		if(root == null || root.report == null) return false;
		if(root == n) return true;
		for(int i=0;i<root.report.size();i++){
			Employee currReport = root.report.get(i);
			if(cover(currReport,n)){
				return true;
			}
		}
		return false;
	}
}

class Employee{
	String name;
	ArrayList<Employee> report;
	
	public Employee(String name, ArrayList<Employee> reports){
		this.name = name;
		this.report = reports; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
