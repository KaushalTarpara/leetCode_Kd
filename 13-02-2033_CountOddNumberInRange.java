class 13-02-2033_CountOddNumberInRange{
    public int countOdds(int low, int high) {
    
    if (low % 2 == 0) {
        low++;
    }

    if (high % 2 == 0) {
        high--;
    }
    return (high - low) / 2 + 1;
    }
}