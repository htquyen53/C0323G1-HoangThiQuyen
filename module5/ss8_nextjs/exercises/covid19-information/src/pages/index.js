import { Inter } from 'next/font/google';
import * as covidInforService from "../pages/service/CovidInfoService";
import axios from 'axios';

const inter = Inter({ subsets: ['latin'] })

export default function Home0({ data }) {
  return (
    <div className='title'>
      <h1>Vietnam's COVID-19 Information</h1>
      <table>
        <thead>
          <tr>
            <th>Date</th>
            <th>Confirmed</th>
            <th>Active</th>
            <th>Recovered</th>
            <th>Deaths</th>
          </tr>
        </thead>
        <tbody>
          {data.map((info, index) => (
            <tr key={index}>
              <td>{info.Date}</td>
              <td>{info.Confirmed}</td>
              <td>{info.Active}</td>
              <td>{info.Recovered}</td>
              <td>{info.Deaths}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
export async function getStaticProps(context) {
  // fetch dữ liệu từ file system, API, DB,...
  const data = (await axios.get('http://localhost:8000/covidInfo')).data;
  // Giá trị của `props` sẽ được truyền tới component `Home`
  return {
    props: {
      data
    }
  }
}
