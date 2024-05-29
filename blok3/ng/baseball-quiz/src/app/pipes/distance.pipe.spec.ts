import {DistancePipe} from './distance.pipe';

describe('DistancePipe', () => {
  let sut: DistancePipe;

  beforeEach(() => {
    sut = new DistancePipe();
  });

  it('create an instance', () => {
    expect(sut).toBeTruthy();
  });

  it('should return 42.00 km', () => {
    expect(sut.transform(42.195, 2, 'km')).toBe("42.20km")
  });

});
