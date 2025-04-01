import { Component, Input, OnInit } from '@angular/core';
import Dog from 'src/app/models/Dog.model';
import { DogFormMode, DogService } from 'src/app/services/dog.service';

@Component({
  selector: 'app-dog-display',
  templateUrl: './dog-display.component.html',
  styleUrls: ['./dog-display.component.css']
})
export class DogDisplayComponent implements OnInit {

  @Input() dogId = "";

  dog: Dog | null = null;

  constructor(private dogService: DogService) {}

  ngOnInit(): void {
    // Pas besoin de souscrire car le composant parent souscrit à la liste de chiens
    this.dog = this.dogService.getDogById(this.dogId);
  }

  onClickButton(dogFormMode: DogFormMode) { 
    this.dogService.switchDogFormMode(dogFormMode);
    this.dogService.switchSelectedDog(this.dogId);
  }
}
