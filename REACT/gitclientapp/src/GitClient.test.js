import axios from 'axios';
import GitClient from './GitClient';

// Tell Jest to mock the entire axios module
jest.mock('axios');

describe("Git Client Tests", () => {
    
    test("should return repository names for techiesyed", async () => {
        // 1. Define the dummy data we want the mock to return
        const mockData = {
            data: [
                { name: 'appscentricsolutions' },
                { name: 'ArrayListDemo' },
                { name: 'CleanArchitecture' }
            ]
        };

        // 2. Configure the mock object to resolve with our dummy data
        axios.get.mockResolvedValue(mockData);

        // 3. Invoke the method
        const response = await GitClient.getRepositories('techiesyed');

        // 4. Assertions: Verify it returned the mocked data and called the correct URL
        expect(response.data.length).toBe(3);
        expect(response).toEqual(mockData);
        expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
    });

});