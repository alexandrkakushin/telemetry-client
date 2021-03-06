import { Component } from '@angular/core';
import { CpuRepository } from "../../model/repository/cpu.repository";
import { Cpu } from "../../model/cpu.model";

@Component({
  selector: 'cpu-usage',
  templateUrl: './cpu-usage.component.html'
})

export class CpuUsageComponent {

  constructor(private repository: CpuRepository) {}

  get load(): number {
    let cpu: Cpu = null;
    cpu = this.repository.getCpu();
    if (cpu == null) {
      return 0;
    } else {
      return cpu.load;
    }
  }

  get cpu(): Cpu {
    return this.repository.getCpu();
  }
}
