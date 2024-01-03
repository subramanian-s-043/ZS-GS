package com.subramanians.rolehierarchy.ceo;

import java.util.Scanner;

public class RoleView {
	RoleViewModel roleViewModel;
	Scanner scanner=new Scanner(System.in);
	public boolean isCeo=false;
	
	public RoleView() {
		roleViewModel=new RoleViewModel(this);
	}
	
	public void showOperations()
	{
		boolean run=true;
		System.out.println("Operations: ");
		while(run)
		{
			System.out.println(" 1. Add Sub Roles \n 2.Display Roles \n 3.Delete Role \n 4.Add User \n 5.View User \n 0.Exit ");
			System.out.println("Operations to be Performed: ");
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the sub-Role name: ");
				String subRole=scanner.nextLine();
				System.out.println("Enter the Repoting to Role name: ");
				String reportingTo;
				do {
					reportingTo=scanner.nextLine();
				}while(roleViewModel.validateReportingTo(reportingTo));
				roleViewModel.setSubRole(subRole,reportingTo);
				break;
			case 2:
				roleViewModel.showReportingStaffs();
				break;
			case 3:
				getRole();
				break;
			case 4:
				getUsers();
				break;
			case 5:
				roleViewModel.viewUser();
				break;
			case 0:
				run=false;
				break;
			}
		}
	}

	private void getUsers() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username=scanner.nextLine();
		System.out.println("Enter the Role: ");
		String role=scanner.nextLine();
		roleViewModel.createUser(username,role);
	}

	private void getRole() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Role to Delete: ");
		String role=scanner.nextLine();
		System.out.println("Enter the Role to be Transferred");
		String transfer=scanner.nextLine();
		roleViewModel.deleteRole(role,transfer);
		
	}

	public void getCeo() {
		System.out.println("Enter the root role name: ");
		String ceo=scanner.next();
		roleViewModel.setCeo(ceo);
	}
	
	public void showMessage(String msg) {
		if(msg.equals(""))
		{
			System.out.println();
		}else
		{
			System.out.print(msg);			
		}
	}
}