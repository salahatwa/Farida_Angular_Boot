import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'servicesFilter'
})
export class ServicesFilterPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
