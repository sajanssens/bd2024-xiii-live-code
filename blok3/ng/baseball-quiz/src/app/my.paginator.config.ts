import {Injectable} from "@angular/core";
import {MatPaginatorIntl} from "@angular/material/paginator";
import {Subject} from "rxjs";

@Injectable()
export class MyPaginatorConfig implements MatPaginatorIntl {
  changes = new Subject<void>();

  // For internationalization, the `$localize` function from
  // the `@angular/localize` package can be used.
  firstPageLabel = $localize`Eerste`;
  itemsPerPageLabel = $localize`Items`;
  lastPageLabel = $localize`Laatste`;

  // You can set labels to an arbitrary string too, or dynamically compute
  // it through other third-party internationalization libraries.
  nextPageLabel = 'Volgende';
  previousPageLabel = 'Vorige';

  getRangeLabel(page: number, pageSize: number, length: number): string {
    if (length === 0) {
      return $localize`1 van 1`;
    }
    const amountPages = Math.ceil(length / pageSize);
    return $localize`${page + 1} van ${amountPages}`;
  }
}
