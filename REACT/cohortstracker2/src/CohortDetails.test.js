import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

describe("Cohort Details Component", () => {
  
  // Test - 1: should create the component (shallow render in isolation)
  test("should create the component", () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.exists()).toBe(true);
  });

  // Test - 2: should initialize the props
  test("should initialize the props", () => {
    // mount() does a full DOM render to properly check props
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    expect(wrapper.props().cohort).toEqual(CohortData[0]);
  });

  // Test - 3: should display cohort code in h3
  test("should display cohort code in h3", () => {
    const wrapper = mount(<CohortDetails cohort={CohortData[0]} />);
    // Find the h3 element and verify its text matches the data
    const h3Text = wrapper.find('h3').text();
    expect(h3Text).toBe(CohortData[0].cohortCode);
  });

  // Test - 4: should always render same html (Snapshot test)
  test("should always render same html", () => {
    const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
    // Creates a snapshot file on the first run to compare against future runs
    expect(wrapper).toMatchSnapshot();
  });

});