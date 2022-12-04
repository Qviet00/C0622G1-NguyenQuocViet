import {CustomerType} from "./customerType";

export interface Customer {
  id?:number;
  name?:string;
  dateOfBirth?: string;
  idCard?: string;
  phone?: string;
  email?: string;
  address?: string;
  gender?:string;
  customerType?: CustomerType;
}
