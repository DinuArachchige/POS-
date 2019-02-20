export class Items {


  constructor (private code?: string, private discription?: string, private qtyOnHand?: number, private unicPrice?: number) {
  }
  get Code(): string {
    return this.code;
  }
  get Discription(): string {
    return this.discription;
  }
  get QtyOnHand(): number {
    return this.qtyOnHand;
  }
  get UnicPrice(): number {
    return this.unicPrice;
  }

  set Code(value: string) {
    this.code = value;
  }
  set Discription(value: string) {
    this.discription = value;
  }
  set QtyOnHand(value: number) {
    this.qtyOnHand = value;
  }
  set UnicPrice(value: number) {
    this.unicPrice = value;
  }

}
