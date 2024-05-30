import {Gender} from "./gender";

export interface Contact {
  firstName: string;
  surname: string;
  email: string;
  gender: Gender;
  id?: number;
}
