export interface Gender {
  name: string;
  id?: number;
}

export const GENS: Gender[] = [
  {id: 1, name: 'Male'},
  {id: 2, name: 'Female'}
];
