import { ServiceStack } from '../utils/service-stack.enum';
import { ServiceLevel } from '../utils/service-level.enum';
import { ServiceCategory } from '../models/service-category';

export class Service {
    id: Number;
    description: String;
    isMigrated: boolean;
    name: String;
    ownerService: String;
    serviceReversal: String;
    serviceStackId: String;

    serviceStackType: ServiceStack;
    level: ServiceLevel;

    category: ServiceCategory;
}
