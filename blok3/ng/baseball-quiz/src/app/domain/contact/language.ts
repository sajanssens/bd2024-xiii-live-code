export interface Language {
  name: string;
  id?: number;
}

export const LANGS: Language[] = [
  {id: 1, name: 'Java'},
  {id: 2, name: 'Kotlin'},
  {id: 3, name: 'Typescript'},
  {id: 4, name: 'PHP'},
  {id: 5, name: 'JS'},
  {id: 6, name: 'COBOL!!'}
];
