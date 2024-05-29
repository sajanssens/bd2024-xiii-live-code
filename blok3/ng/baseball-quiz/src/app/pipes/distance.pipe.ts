import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'distance',
  standalone: true
})
export class DistancePipe implements PipeTransform {

  transform(value: number, digits = 0, unit = 'm'): string {
    return `${value.toFixed(digits)} ${unit}`;
  }

}
