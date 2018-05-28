import { ServiceConfigMap } from '../models/service-config-map';
import { OfferedServiceType } from '../models/offered-service-type';
import { BusinessServiceStep } from '../models/business-service-step';

export class BusinessServiceConfig {

    id: Number;
    bankingAgent: boolean;
    isDefaultService: boolean;
    isExposable: boolean;
    isMultiWallet: boolean;

    name: String;

    steps: Array<BusinessServiceStep>;

    businessServiceType: ServiceConfigMap;
    segmentationType: OfferedServiceType ;


    setServiceConfigMap(serviceMap: ServiceConfigMap) {
        this.businessServiceType = serviceMap;
    }

    getServiceConfigMap() {
        return this.businessServiceType;
    }

    setSegmentationType(segmentationType: OfferedServiceType) {
        this.segmentationType = segmentationType;
    }

    getSegementationType() {
        return this.segmentationType;
    }
}
