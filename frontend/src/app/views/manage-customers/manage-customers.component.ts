import {Component, OnInit, ViewChild} from '@angular/core';
import {CustomerService} from '../../services/customer.service';
import {Customer} from '../../dtos/customer';
import {NgForm} from '@angular/forms';
import {Items} from '../../dtos/items';


@Component({
  selector: 'app-manage-customers',
  templateUrl: './manage-customers.component.html',
  styleUrls: ['./manage-customers.component.css']
})
export class ManageCustomersComponent implements OnInit {

  customers: Array<Customer> = [];
  selectedCustomer: Customer = new Customer();
  tempCustomer: Customer = null;
  manuallySelected = true;
  inputDisabled = true;
  count = 0;
  @ViewChild('frmCustomers') frmCustomers: NgForm;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
    this.loadAllCustomers();
  }
  clear(): void {
    const index = this.customers.indexOf(this.selectedCustomer);
    if (index !== -1) {
      this.customers[index] = this.tempCustomer;
      this.tempCustomer = null;
    }
    this.selectedCustomer = new Customer;
    this.manuallySelected = false;
  }

  loadAllCustomers(): void {
    this.customerService.getAllCustomers().subscribe(
      (result) => {
        this.customers = result;
        // console.log(this.customers);
      }
    );
  }

  update(id): void {
      this.customerService.saveCustomer(this.selectedCustomer).subscribe(

        (result) => {
          if (result) {
            alert('Customer has been Updated successfully');
            this.loadAllCustomers();
            this.clear();
            this.manuallySelected = true;
          } else {
            alert('Failed to update the customer');
          }
        }
      );
  }
  searchCustomer(): void {
      this.customerService.searchCustomer(this.selectedCustomer.id).subscribe(
      (result) => {
      this.selectedCustomer = result;
     // console.log(this.selectedCustomer);
      if (!result) {

        alert('Customer Not Found !');
        // this.clear(x);
      //  this.selectedCustomer = null;

      }
  }
);

}
  deleteCustomer(id): void {
      if (confirm('Are you sure you want to delete this customer?')) {
        this.customerService.deleteCustomer(id).subscribe(
          (result) => {
            if (result) {
              alert('Customer has been deleted successfully');
              this.loadAllCustomers();
            } else {
              alert('Failed to delete the customer');
            }
            this.loadAllCustomers();
          }
        );
      }
  }

  tableClick(customer: Customer): void {
    this.customerService.searchCustomer(customer.id).subscribe(
      (result) => {
        this.selectedCustomer = result;
    //    console.log(this.selectedCustomer);

      });

  }

  saveCustomer(): void {
    this.customerService.saveCustomer(this.selectedCustomer).subscribe(
      (result) => {
        if (result) {
          alert('Customer has been saved successfully');
          this.loadAllCustomers();
          this.clear();
          this.manuallySelected = true;
        } else {
          alert('Failed to save the customer');

        }
      }
    );
  }

  check() {
    this.count++;
      if (this.count === 1) {
        this.manuallySelected = false;

      }
      if (this.count > 1) {
        this.manuallySelected = true;

        this.count = 0;
      }

  }
  selectCustomer(customer: Customer): void {
    this.clear();
    this.selectedCustomer = customer;
  }

}
