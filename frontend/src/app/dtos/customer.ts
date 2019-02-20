export class Customer {


  constructor(private id?: string, private name?: string, private address?: string) {
  }


  get Id(): string {
    return this.id;
  }

  get Name(): string {
    return this.name;
  }
  get Address(): string {
    return this.address;
  }


  set Id(value: string) {
    this.id = value;
  }
  set Name(value: string) {
    this.name = value;
  }
  set Address(value: string) {
    this.address = value;
  }
}



