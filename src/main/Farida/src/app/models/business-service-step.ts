import { BusinessServiceConfig } from '../models/business-service-config';
import { Service } from '../models/service';
import { BusinessStepType } from '../utils/business-step-type.enum';


export class BusinessServiceStep {

    id: Number;
    businessServiceConfig: BusinessServiceConfig = new BusinessServiceConfig();
    description: String;
    isMigrated: boolean;
    stepOrder: Number;

    service: Service = new Service();
    type: BusinessStepType;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }

    setStepOrder(order: Number) {
        this.stepOrder = order;
    }
}
