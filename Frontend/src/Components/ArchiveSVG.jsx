export default function ArchiveSVG({ ...rest }) {
  return (
    <svg
      {...rest}
      width={16}
      height={16}
      viewBox="0 0 11 11"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M2 3L7 3"
        stroke="white"
        stroke-linecap="round"
      />
      <path
        d="M2 5H5"
        stroke="white"
        stroke-linecap="round"
      />
      <path
        d="M2 7H9"
        stroke="white"
        stroke-linecap="round"
      />
      <mask id="path-4-inside-1_12_905" fill="white">
        <path d="M0 2C0 0.895431 0.895431 0 2 0H11V9C11 10.1046 10.1046 11 9 11H2C0.895431 11 0 10.1046 0 9V2Z" />
      </mask>
      <path
        d="M11 0H12V-1H11V0ZM2 1H11V-1H2V1ZM10 0V9H12V0H10ZM9 10H2V12H9V10ZM1 9V2H-1V9H1ZM2 10C1.44772 10 1 9.55228 1 9H-1C-1 10.6569 0.343146 12 2 12V10ZM10 9C10 9.55228 9.55228 10 9 10V12C10.6569 12 12 10.6569 12 9H10ZM2 -1C0.343146 -1 -1 0.343146 -1 2H1C1 1.44772 1.44772 1 2 1V-1Z"
        fill="white"
        mask="url(#path-4-inside-1_12_905)"
      />
    </svg>
  )
}
