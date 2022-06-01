import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatisticsAttractionLastmonthComponent } from './statistics-attraction-lastmonth.component';

describe('StatisticsAttractionLastmonthComponent', () => {
  let component: StatisticsAttractionLastmonthComponent;
  let fixture: ComponentFixture<StatisticsAttractionLastmonthComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatisticsAttractionLastmonthComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StatisticsAttractionLastmonthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
