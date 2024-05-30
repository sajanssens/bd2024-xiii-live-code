import {DistancePipe} from './distance.pipe';

// Class
describe('DistancePipe', () => {
  let sut: DistancePipe;

  beforeEach(() => {
    sut = new DistancePipe();
  });

  // @Test
  it('create an instance', () => {
    // arrange
    // act
    // assert
    expect(sut).toBeTruthy();
  });

  // @Test
  it('should return 42.00 km', () => {
    // arrange (bovenin)

    // act
    let actual = sut.transform(42.195, 2, 'km');

    // assert
    expect(actual).toBe("42.20 km")
  });

});
